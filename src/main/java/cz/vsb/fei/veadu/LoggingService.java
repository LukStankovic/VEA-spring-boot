package cz.vsb.fei.veadu;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Aspect
public class LoggingService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* cz.vsb.fei.veadu.controlers.*.*(..))")
	public void log(JoinPoint joinPoint) {
		log.info("Loading controller: " + joinPoint.getSignature());	
		
		List<Object> arguments = Arrays.asList(joinPoint.getArgs());

		if (joinPoint.getArgs().length > 1) {
			log.info("Post arguments: ");
			for (Object a : arguments) {
				log.info(a.toString());
			}
		}
		log.info("End of action.");
	}
}
