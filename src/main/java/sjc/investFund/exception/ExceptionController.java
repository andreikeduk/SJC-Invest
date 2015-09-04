package sjc.investFund.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController{
	
	@ExceptionHandler(AlredyExistException.class)
	public ModelAndView alredyExistHandler(AlredyExistException ex) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("errorMsg", ex.getMsg());
		mav.setViewName("error");
		return mav;
	}
//	@ExceptionHandler(Exception.class)
//	public ModelAndView handleAllException(Exception ex) {
//
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("generic_error");
//		mav.addObject("errorMsg", "Unknown error");
//
//		return mav;
//
//	}
}
