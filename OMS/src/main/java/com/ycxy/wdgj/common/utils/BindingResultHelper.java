package com.ycxy.wdgj.common.utils;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.ycxy.wdgj.common.exception.OmsException;

public class BindingResultHelper {
	public static void cacheExceptions(BindingResult result) throws OmsException{
		if(result.hasErrors()){
    		List<FieldError> fieldErrorList=result.getFieldErrors();
    		if(!ObjectUtils.isEmpty(fieldErrorList)){
    			String errorMsg="";
    			for(FieldError fieldError:fieldErrorList){
    				errorMsg+=fieldError.getField()+",";
    			}
    			throw new OmsException(errorMsg);
    		}
    	}
	}
}
