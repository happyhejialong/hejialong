jkUtils = {
    math: {
        add: function (a, b) {
            var c, d, e;
            try {
                c = a.toString().split(".")[1].length;
            } catch (f) {
                c = 0;
            }
            try {
                d = b.toString().split(".")[1].length;
            } catch (f) {
                d = 0;
            }
            return e = Math.pow(10, Math.max(c, d)), (mul(a, e) + mul(b, e)) / e;
        },

        sub: function (a, b) {
            var c, d, e;
            try {
                c = a.toString().split(".")[1].length;
            } catch (f) {
                c = 0;
            }
            try {
                d = b.toString().split(".")[1].length;
            } catch (f) {
                d = 0;
            }
            return e = Math.pow(10, Math.max(c, d)), (mul(a, e) - mul(b, e)) / e;
        },

        mul: function (a, b) {
            var c = 0,
                d = a.toString(),
                e = b.toString();
            try {
                c += d.split(".")[1].length;
            } catch (f) { }
            try {
                c += e.split(".")[1].length;
            } catch (f) { }
            return Number(d.replace(".", "")) * Number(e.replace(".", "")) / Math.pow(10, c);
        },

        div: function (a, b) {
            var c, d, e = 0,
                f = 0;
            try {
                e = a.toString().split(".")[1].length;
            } catch (g) { }
            try {
                f = b.toString().split(".")[1].length;
            } catch (g) { }
            return c = Number(a.toString().replace(".", "")), d = Number(b.toString().replace(".", "")), mul(c / d, Math.pow(10, f - e));
        }
    },

    cookie: {
        setCookie: function (cname, cvalue, exdays) {
            var d = new Date();
            d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
            var expires = "expires=" + d.toUTCString();
            document.cookie = cname + "=" + cvalue + "; " + expires;
        },

        getCookie: function (cname) {
            var name = cname + "=";
            var ca = document.cookie.split(';');
            for (var i = 0; i < ca.length; i++) {
                var c = ca[i];
                while (c.charAt(0) === ' ') c = c.substring(1);
                if (c.indexOf(name) !== -1) return c.substring(name.length, c.length);
            }
            return "";
        }
    },

    jkGetSign: function (urlParam, bodyParam, isReturnUrl) {
        var _bodyParam = (typeof bodyParam === 'undefined') ? "" : bodyParam;
        var _isReturnUrl = (typeof isReturnUrl === 'undefined') ? true : isReturnUrl;

        var getSignParam = [];
        var _timestamp = {};

        var body = {};
        if (typeof urlParam !== 'undefined') {
            body = $.extend(true, {}, urlParam);
        } else { }

        //时间戳
        _timestamp.key = 'timestamp';
        _timestamp.value = String((new Date()).valueOf());
        getSignParam.push(_timestamp);

        //token
        var _access_token = {};
        _access_token.key = 'access_token';
        if (typeof window.get_token !== 'undefined') {
            _access_token.value = 'Bearer ' + window.get_token();
        } else {
            _access_token.value = '';
        }
        getSignParam.push(_access_token);

        //appkey
        var _appkey = {};
        _appkey.key = 'appkey';
        _appkey.value = 'app_jackyun_manager';
        getSignParam.push(_appkey);

        //urlParam
        for (var key in urlParam) {
            var t = {};
            t.key = key;
            var vv = urlParam[key];

            if ((typeof vv === 'object')) {
                t.value = JSON.stringify(vv);
            } else {
                t.value = String(vv);
            }
            getSignParam.push(t);
        }

        var _data = {};
        _data.data = getSignParam;
        _data = JSON.stringify(_data);

        var _sign;
        if (typeof window.make_sign !== 'undefined') {
            _sign = window.make_sign(_data, _bodyParam).toUpperCase();
        } else {
            _sign = '';
        }

        if (_isReturnUrl) {
            var s = 'timestamp=' + _timestamp.value;
            s = s + '&access_token=' + _access_token.value;
            s = s + '&appkey=' + _appkey.value;
            s = s + '&sign=' + _sign;

            for (var k in body) {
                if (typeof body[k] === 'object') {
                    s = s + '&' + k + '=' + JSON.stringify(body[k]);
                }
                else {
                    s = s + '&' + k + '=' + String(body[k]);
                }
            }
            console.log(s);
            return encodeURI(s);
        } else {
            body.timestamp = _timestamp.value;
            body.access_token = _access_token.value;
            body.appkey = _appkey.value;
            body.sign = _sign;
            return body;
        }
    },

    closeWindow: function (action) {
        if (window.CloseOwnerWindow) return window.CloseOwnerWindow(action);
        else window.close();
    },

    downloadFile: function (url, filename) {
        var a = document.createElement('a');
        a.href = url;
        a.download = filename;
        a.click();
    },

    readWord: function (text, config = null) {
        var defaultConfig = {
            volume: 1,
            rate: 1.8,
            pitch: 1
        };

        if (config) {
            if (config.volume) defaultConfig.volume = config.volume;
            if (config.rat) defaultConfig.rate = config.rate;
            if (config.pitch) defaultConfig.pitch = config.pitch;
        }

        var speech = new SpeechSynthesisUtterance();
        speech.text = text;
        speech.volume = defaultConfig.volume;
        speech.rate = defaultConfig.rate;
        speech.pitch = defaultConfig.pitch;

        window.speechSynthesis.speak(speech);
    },

    printer: {
        getAll: function () {
            var result = [];
            if (typeof window.print_get_all !== 'undefined') {
                var data = window.print_get_all();
                if (data)
                    result = JSON.parse(data);
            }

            return result;
        }
    },

    localConfig: {
        getByModule: function (moduleId) {
            var result = '';
            if (typeof window.print_get_one !== 'undefined')
                result = window.print_get_one(moduleId);

            return result;

        },

        setForModule: function (moduleId, value) {
            var result = '';
            if (typeof window.print_set_one !== 'undefined')
                result = window.print_set_one(moduleId, value);

            return result;
        },

        deleteByModule: function (moduleId) {
            if (typeof window.print_del_one !== 'undefined')
                window.print_del_one(moduleId);
        }
    }
};

jkEnums = {
    // 通用操作码
    CommonAction: {
        Add: 1,
        Edit: 2,
        Delete: 3,
        Copy: 4,
        BatchEdit: 5
    },

    // 通用返回码
    CommonRspCode: {
        Success: '200'
    }

};

//mini.Form.getData反混淆之后的代码，增加了isArray参数，用来获取数组格式的数据
mini.Form.prototype.getData = function (isForm, isDepth, isArray) {
    if (mini.isNull(isDepth)) isDepth = true
    var getValueHandlerName = isForm ? "getFormValue" : "getValue"
    var fields = this.getFields()
    var result = {};
    for (var i = 0, length = fields.length; i < length; i++) {
        var field = fields[i], getValueHandler = field[getValueHandlerName]
        if (!getValueHandler) continue
        if (field.name) {
            if (isDepth == true)
                mini._setMap(field.name, getValueHandler.call(field), result)
            else
                result[field.name] = getValueHandler.call(field)
        }

        if (field.textName && field.getText)
            if (isDepth == true)
                mini._setMap(field.textName, field.getText(), result)
            else
                result[field.textName] = field.getText()
        if (isArray & field.multiSelect) {
            var key = field.name || (field.getText && field.textName)
            result[key] = result[key].split(',').filter(function (value) {
                return value !== ""
            })
        }
    }
    return result
};

(function (window) {
    $.ajaxSetup({
        beforeSend: function (request) {
            var tokenpre = "Bearer ";
            var token = tokenpre;
            if (typeof window.get_token !== 'undefined') {
                token = token + window.get_token();
                request.setRequestHeader("Authorization", token);
            } else {
                request.setRequestHeader("mem_name", "jackyun_dev"); //mem_name    
                request.setRequestHeader("mem_id", 12);
            }
        }
    });


})(window);
