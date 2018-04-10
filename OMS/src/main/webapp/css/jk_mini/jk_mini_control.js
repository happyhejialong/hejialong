(function (window, mini) {
    if (!window.JKControl) window.JKControl = {};

    //表格组件
    JKControl.JKDataGrid = function () {
        JKControl.JKDataGrid.superclass.constructor.call(this);

        this.initComponents();
        this.bindEvents();
    };

    var GridContextMenu = function (menuItems) {
        this.menu = this.createMenu(menuItems);
        this.menuItems = menuItems;

        this.menu.on('beforeopen', this.onBeforeOpen, this);
        return this.menu;
    };

    GridContextMenu.prototype = {
        createMenu: function (menuItems) {
            var menu = mini.create({
                type: "menu",
                hideOnClick: false
            });

            menu.setItems(menuItems);
            menu.on("itemclick", this.onMenuItemClick, this);
            return menu;
        },
        onBeforeOpen: function (e) { },

        onMenuItemClick: function (e) {
            var item = e.item;
            var menu = e.sender;
            console.log(item);
            item.click();
            menu.hide();
        }
    };

    var GridHeaderMenu = function (grid) {
        this.grid = grid;
        this.menu = this.createMenu();
        this.currentColumn = null;

        this.menu.on('beforeopen', this.onBeforeOpen, this);
        grid.setHeaderContextMenu(this.menu);
    };

    GridHeaderMenu.prototype = {
        menuItems: [{
            text: "自定义列",
            name: "setColumn"
        },
        {
            text: "锁定此列",
            name: "frozenColumn"
        },
        {
            text: "分组此列",
            name: "groupColumn",
        },
        {
            text: "*保存表格布局",
            name: "saveTableLayout"
        }
        ],

        createMenu: function () {
            var menu = mini.create({
                type: "menu",
                hideOnClick: false
            });

            menu.setItems(this.menuItems);
            menu.on("itemclick", this.onMenuItemClick, this);
            return menu;
        },
        onBeforeOpen: function (e) {
            var grid = this.grid;
            var column = grid.getColumnByEvent(e.htmlEvent);
            this.currentColumn = column;
        },
        onMenuItemClick: function (e) {
            var grid = this.grid;
            var menuItems = this.menuItems;
            var menu = e.sender;
            var item = e.item;
            var currentColumn = this.currentColumn;

            function setMenuItemText(name, text) {
                console.log(menuItems);
                for (let i = 0; i < menuItems.length; i++) {
                    if (menuItems[i].name === name)
                        menuItems[i].text = text;
                }
                menu.setItems(menuItems);
            }

            if (item.name === 'setColumn') {
                alert('开发中...');
            } else if (item.name === 'frozenColumn') {
                var frozenEndColumn = grid.getFrozenEndColumn();
                if (!currentColumn.visible) return;
                if (frozenEndColumn !== -1) {
                    grid.unFrozenColumns();
                    item.text = '锁定此列';

                } else {
                    grid.frozenColumns(0, currentColumn._index);
                    item.text = '解锁此列';
                }
            } else if (item.name === 'groupColumn') {
                alert(grid.hasGroup);
                if (grid.hasGroup) {
                    grid.clearGroup();
                    grid.hasGroup = false;
                    item.text = '分组此列';
                } else {
                    grid.groupBy(currentColumn.field);
                    grid.hasGroup = true;
                    item.text = '取消分组';
                }
            } else if (item.name === 'saveTableLayout') {
                alert('开发中...');
            }


            menu.hide();
            setMenuItemText(item.name, item.text);
        }
    };

    mini.extend(JKControl.JKDataGrid, mini.DataGrid, {
        uiCls: 'jk-mini-base-datagrid',

        initComponents: function () {

            new GridHeaderMenu(this);

            var that = this;

            this.defaultColumns = [];

            this.businessColumns = [];

            this.contextMenuItems = [];

            this.defaultMenuItems = [{
                text: "刷新",
                name: "refresh",
                click: function () {
                    that.reload();
                }
            },
            {
                text: "全选",
                name: "selectAll",
                click: function () {
                    that.selectAll(false);
                }
            },
            {
                text: "反选",
                name: "deselectAll",
                click: function () {
                    that.deselectAll(false);
                }
            },
            {
                text: "复制",
                name: "copy",
                children: [{
                    text: ' *复制所选',
                    name: 'copySelect',
                    click: function () {
                        var rows = that.getSelecteds();
                        console.log(rows);
                        alert('开发中');
                    }
                }, {
                    text: ' *复制当前行',
                    name: 'copyCurRow',
                    click: function () {
                        //var row = that.getRowByEvent(this.htmlEvent);
                        //console.log(row);
                        alert('开发中');
                    }
                }
                    /*, '-', {
                                                text: ' *商品价格',
                                                display: false,
                                                name: 'p1'
                                            },
                                            '-'*/
                    , {
                    text: ' *自定义复制设置',
                    name: 'configCopy'
                }
                ]
            }
            ];

            this.customMenuItems = [];

            this.set({
                sortMode: 'client', //客户端排序
                fitColumns: false, //列固定尺寸
                multiSelect: true, //行多选
                pageSize: 30,
                sizeList: [30, 60, 90],
                allowCellWrap: true, //允许换行
                allowEmptyContextMenu: true,
                pagerButtons: '',
                ajaxType: 'post',
                showExpandColumn: false,
                showIndexColumn: true,
                showCheckColumn: true,
            });

            //通用表格ajax请求选项，如果需要特殊处理，覆写该方法
           this.setAjaxOptions({
                dataFilter: function (result) {
                    var data = JSON.parse(result);
                    return data;
                //    if (data.code === jkEnums.CommonRspCode.Success * 1)
            //            return JSON.stringify(data.result.data);
            //        else {
            //            mini.alert(data.msg);
            //            return [];
            //        }
                }
            });
        },

        bindEvents: function () {
            var that = this;
            var begReqTime;
            var finishReqTime;

            function displayPagerInfo() {
                var pagerInfo = that.getBottomPager();
                var pageInfoText = '共  <span style="font-size: 16px" >{0}</span>  条 | 已勾选  <span style="font-size: 16px" >{1}</span>  条';
                pageInfoText = String.format(pageInfoText, that.totalCount, that.getSelecteds().length); //, that.indexOf(that.getSelected()) + 1
                $(pagerInfo._rightEl).html(pageInfoText);

                var s = String.format('本次查询耗时 {0} 秒', finishReqTime / 1000);
                var divQryTimeID = 'jkQryTime' + that._id;
                var divQryTime = $('#' + divQryTimeID);
                if (divQryTime.length === 0) {
                    that.setPagerButtons('<span style="display: inline-block; margin-top: 4px" id=' + divQryTimeID + '>' + s + '</span>');
                } else {
                    divQryTime.html(s);
                }
            }

            this.on('rowdblclick', function () { });

            this.on('selectionchanged', function () {
                displayPagerInfo();
            });

            this.on('beforeload', function (e) {
                begReqTime = new Date();

                var url = this.url;
                var idx = url.indexOf('?');
                if (idx !== -1) {
                    var params = url.substr(idx + 1).split("&");
                    for (var i = 0; i < params.length; i++) {
                        var key = params[i].split("=")[0];
                        var value = unescape(params[i].split("=")[1]);
                        e.data[key] = value;
                    }
                }

                e.data = jkUtils.jkGetSign(e.data, "");
                return e;
            });

            this.on('load', function () {
                finishReqTime = new Date() - begReqTime;
                displayPagerInfo();

                var cur_max_index = (this.pageIndex + 1) * this.pageSize + '';
                var len = cur_max_index.length;
                this.setColumnWidth('#indexcolumn#', 25 + len * 5);
            });

            this.on('drawgroup', function (e) {
                e.cellHtml = e.value + ': ' + e.rows.length;
            });
        },

        _removeDefaultColumn: function (column) {
            var i = 0;
            while (i < this.defaultColumns.length) {
                if ((typeof column !== 'undefined') && (this.defaultColumns[i].type === column.type))
                    this.defaultColumns.splice(i, 1);
                else
                    i = i + 1;
            }
        },

        setColumns: function (columns) {
            this.businessColumns = columns;
            var _columns = this.defaultColumns.concat(this.businessColumns);
            JKControl.JKDataGrid.superclass.setColumns.call(this, _columns);
        },

        setMenuItems: function (items) {
            var defaultMenuItemsVisible = false;
            this.customMenuItems = items;

            for (var i = 0; i < this.defaultMenuItems.length; i++) {
                if ((typeof this.defaultMenuItems[i].visible === 'undefined') ||
                    (this.defaultMenuItems[i].visible)) break;
            }

            if (i === this.defaultMenuItems.length) defaultMenuItemsVisible = false;
            else defaultMenuItemsVisible = true;

            if ((this.customMenuItems.length > 0) && (defaultMenuItemsVisible)) {
                this.contextMenuItems = this.defaultMenuItems.concat(['-'])
                    .concat(this.customMenuItems);
            } else if ((this.customMenuItems.length === 0) && (defaultMenuItemsVisible)) {
                this.contextMenuItems = this.defaultMenuItems;
            } else {
                this.contextMenuItems = this.customMenuItems
            }

            this.setContextMenu(new GridContextMenu(this.contextMenuItems));
        },

        setMenuItemSelectAll: function (visible) {
            this.defaultMenuItems[1].visible = visible;
            this.defaultMenuItems[2].visible = visible;
            this.setMenuItems(this.customMenuItems);
        },

        setMenuItemDeselectAll: function (visible) {
            this.setSelectAllMenuItem(visible);
        },

        _setMenuItemCopyWithChildren: function (index, visible) {
            var items = this.defaultMenuItems[3];
            var flag = false;
            items.children[index].visible = visible;
            for (var i = 0; i < items.children.length; i++) {
                if ((typeof items.children[i].visible === 'undefined') || (items.children[i].visible)) {
                    flag = true;
                    break;
                }
            }

            if (!flag) this.setMenuItemCopy(false);
        },

        setMenuItemCopy: function (visible) {
            this.defaultMenuItems[3].visible = visible;
            this.setMenuItems(this.customMenuItems);
        },

        setMenuItemCopySelect: function (visible) {
            this._setMenuItemCopyWithChildren(0, visible);
            this.setMenuItems(this.customMenuItems);
        },

        setMenuItemCopyCurRow: function (visible) {
            this._setMenuItemCopyWithChildren(1, visible);
            this.setMenuItems(this.customMenuItems);
        },

        setMenuItemConfigCopy: function (visible) {
            this._setMenuItemCopyWithChildren(this.defaultMenuItems[3].children.length - 1, visible);
            this.setMenuItems(this.customMenuItems);
        },

        setShowExpandColumn: function (isShow) {
            var expandcolumn = {
                type: 'expandcolumn',
                width: 20,
                name: '#expandcolumn#',
                allowResize: false
            };

            var col = this.getColumn('#expandcolumn#');

            if (isShow) {
                if (typeof col === 'undefined');
                this.defaultColumns.splice(0, 0, expandcolumn);
            } else {
                this._removeDefaultColumn(col);
            }

            this.setColumns(this.businessColumns);
        },

        setShowIndexColumn: function (isShow) {
            var indexcolumnName = '#indexcolumn#';
            var indexcolumn = {
                type: 'indexcolumn',
                header: '#',
                headerAlign: 'center',
                name: indexcolumnName,
                allowResize: false
            };

            var col = this.getColumn(indexcolumnName);
            if (isShow) {
                if (typeof col === 'undefined') {
                    this.defaultColumns.splice(1, 0, indexcolumn);
                }
            } else {
                this._removeDefaultColumn(col);
            }
            this.setColumns(this.businessColumns);
        },

        setMultiSelect: function (m) {
            this.setMenuItemSelectAll(m);
            this.setShowCheckColumn(m);
            JKControl.JKDataGrid.superclass.setMultiSelect.call(this, m);
        },

        setShowCheckColumn: function (isShow) {
            var checkcolumnName = '#checkcolumn#';
            var checkcolumn = {
                type: 'checkcolumn',
                name: checkcolumnName,
                width: 25,
                allowResize: false
            };

            var col = this.getColumn(checkcolumnName);
            if (isShow) {
                if (typeof col === 'undefined')
                    this.defaultColumns.splice(2, 0, checkcolumn);
            } else {
                this._removeDefaultColumn(col);
            }
            this.setColumns(this.businessColumns);
        },

        getAttrs: function (el) {
            var attrs = JKControl.JKDataGrid.superclass.getAttrs.call(this, el);
            mini._ParseBool(el, attrs, ['showExpandcolumn', 'showIndexColumn', 'showCheckColumn']);
            return attrs;
        }
    });

    //button
    JKControl.JKButton = function () {
        JKControl.JKButton.superclass.constructor.call(this);
        this.initComponents();
    };
    mini.extend(JKControl.JKButton, mini.Button, {
        uiCls: 'jk-mini-button',

        initComponents: function () { },
    });

    mini.regClass(JKControl.JKDataGrid, 'JKDataGrid');
    mini.regClass(JKControl.JKButton, 'JKButton');
})(window, mini);
