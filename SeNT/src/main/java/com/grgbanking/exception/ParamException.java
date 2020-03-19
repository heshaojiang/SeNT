package com.grgbanking.exception;

@SuppressWarnings("serial")
public class ParamException extends AppPlaceHolderException
{

	public ParamException(String paramKey)
	{
		super("参数[{0}]没有配置正确", "参数[%s]没有配置正确", paramKey);
	}
}
