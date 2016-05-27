package com.springsource.petclinic.web.exceptions;

import java.util.Enumeration;
import java.util.Properties;

import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * Is necessary to extends SimpleMappingExceptionResolver because default implementation
 * is not checking root cause. This produces that exceptions thrown from Spring Formatters
 * don't match with defined mappings. 
 * 
 * @author Juan Carlos García
 *
 */
public class CauseAdviceSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {

	/**
	 * 
	 * Find a matching view name in the given exception mappings.
	 * @param exceptionMappings
	 *            mappings between exception class names and error view names
	 * @param ex
	 *            the exception that got thrown during handler execution
	 * @return the view name, or {@code null} if none found
	 * @see #setExceptionMappings
	 */
	@Override
	protected String findMatchingViewName(Properties exceptionMappings, Exception ex) {
		String viewName = null;
		String dominantMapping = null;
		int deepest = Integer.MAX_VALUE;
		for (Enumeration<?> names = exceptionMappings.propertyNames(); names.hasMoreElements();) {
			String exceptionMapping = (String) names.nextElement();
			int depth = getDepth(exceptionMapping, ex);
			if (depth >= 0 && (depth < deepest || (depth == deepest &&
					dominantMapping != null && exceptionMapping.length() > dominantMapping.length()))) {
				deepest = depth;
				dominantMapping = exceptionMapping;
				viewName = exceptionMappings.getProperty(exceptionMapping);
			} else if (ex.getCause() instanceof Exception) {
				return findMatchingViewName(exceptionMappings, (Exception) ex.getCause());
			}
		}
		if (viewName != null && logger.isDebugEnabled()) {
			logger.debug("Resolving to view '" + viewName + "' for exception of type [" + ex.getClass().getName() +
					"], based on exception mapping [" + dominantMapping + "]");
		}
		return viewName;
	}
}
