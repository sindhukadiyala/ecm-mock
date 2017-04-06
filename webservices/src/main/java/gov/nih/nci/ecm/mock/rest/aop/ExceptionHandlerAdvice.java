package gov.nih.nci.ecm.mock.rest.aop;

import gov.nih.nci.ecm.mock.ServiceException;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.aop.ThrowsAdvice;


/**
 * This is Advice for handling Exception.
 * 
 * @author Rohit Gupta
 * 
 */
public class ExceptionHandlerAdvice implements ThrowsAdvice {

    /**
     * After Throwing advice.
     * 
     * @param e
     *            -Exception
     */
    @SuppressWarnings({ "PMD.UseStringBufferForStringAppends", "rawtypes" })
    public void afterThrowing(Exception e) {

        String rootCause = ExceptionUtils.getRootCauseMessage(e);

        throw new ServiceException(rootCause, e);
    }
}
