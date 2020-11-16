package cz.vsb.fei.veadu;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingService {

	
	@Before("execution(* cz.vsb.fei.vealab01.controlers.*.*(..))")
	public void log(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature());
		System.out.println(
				Arrays.asList(joinPoint.getArgs()).stream().
				map(a -> a.toString()).collect(Collectors.joining(", ")));
	}

	@Around("execution(* cz.vsb.fei.vealab01.controlers.*.*(..))")
	public Object monitor(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("monitoring....");
		Object retVal = pjp.proceed(pjp.getArgs());
		System.out.println("....done");
		return retVal;
	}

}
