package sjc.investFund.exception;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

	private static final Logger logger = Logger
			.getLogger(ExceptionController.class);

	@ExceptionHandler(AlredyExistException.class)
	public ModelAndView alredyExistHandler(AlredyExistException ex) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("errorMsg", ex.getMsg());
		mav.setViewName("error");
		logger.info(ex.getMsg());
		return mav;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("generic_error");
		mav.addObject("errorMsg", "Unknown error");
		logger.error(ex.toString());
		return mav;
	}
}
