package springbook.learningtest.spring.pointcut;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test-applicationContext.xml")
public class TargetTest {
	@Test
	public void methodSignaturePointcut() throws SecurityException, NoSuchMethodException{
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(public int " + 
				"springbook.learningtest.spring.pointcut.Target.minus(int, int) " + 
				"throws java.lang.RuntimeException)");
		
		assertThat(pointcut.getClassFilter().matches(Target.class) && 
				pointcut.getMethodMatcher().matches(Target.class.getMethod("minus",  int.class, int.class), null), is(true));
		
		assertThat(pointcut.getClassFilter().matches(Target.class) && 
				pointcut.getMethodMatcher().matches(Target.class.getMethod("plus", int.class, int.class), null), is(false));
		
		assertThat(pointcut.getClassFilter().matches(Bean.class) && 
				pointcut.getMethodMatcher().matches(Target.class.getMethod("method"), null), is(false));
	}
}
