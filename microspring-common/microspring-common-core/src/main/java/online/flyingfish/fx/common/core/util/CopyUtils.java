package online.flyingfish.fx.common.core.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

public class CopyUtils<K,T> {
	public static <K,T> T copyProperties(K source, T target) {
		BeanUtils.copyProperties(source, target);
		return target;
	}
	
	public static <K,T> T copyProperties(K source, Class<T> targetClass) {
		T targetInstance = null;
		try {
			targetInstance = targetClass.newInstance();
		} catch (Exception e) {
			throw new IllegalStateException("can not instance class" + targetClass.getName());
		}
		BeanUtils.copyProperties(source, targetInstance);
		return targetInstance;
	}
	
	public static <K,T> T copyPropertiesIgoreNull(K source, Class<T> targetClass) {
		T targetInstance = null;
		try {
			targetInstance = targetClass.newInstance();
		} catch (Exception e) {
			throw new IllegalStateException("can not instance class" + targetClass.getName());
		}
		BeanUtils.copyProperties(source, targetInstance, getNullPropertyNames(source));
		return targetInstance;
	}
	
	private static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		PropertyDescriptor[] pds = src.getPropertyDescriptors();
		Set<String> emptyName = new HashSet<String>();
		for (PropertyDescriptor pd : pds)
		{
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null)
			{
				emptyName.add(pd.getName());
			}
		}
		
		String[] result = new String[emptyName.size()];
		return emptyName.toArray(result);
	}
	
	public static <K,T> T copyPropertiesIgoreNull(K source, T target) {
		BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
		return target;
	}
}
