package com.grgbanking.sent.utils;

import java.util.Collection;

public class CollectionsUtil
{

	@SuppressWarnings("unchecked")
	public static void addAll(Collection coll, Object[] arr)
	{
		for( Object obj : arr )
		{
			coll.add(obj);
		}
	}
}
