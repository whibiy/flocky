package ksmart.ks48team02.common.thymeleaf;

import java.util.Collections;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component(value = "ks") // bean 이름 수정
public class CustomThymeleafDialect extends AbstractDialect implements IExpressionObjectDialect {
	
	
	private final HttpServletRequest request;
	private final HttpServletResponse response;
    
	protected CustomThymeleafDialect(HttpServletRequest request, HttpServletResponse response) {
        super("CustomThymeleafDialect");
		this.request = request;
        this.response = response;
    }

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory() {
        return new IExpressionObjectFactory() {
            @Override
            public Set<String> getAllExpressionObjectNames() {

                return Collections.singleton("ks"); // bean 이름 수정
            }
            @Override
            public Object buildObject(IExpressionContext context, String expressionObjectName) {
                return new CustomThymeleaf(request, response);
            }
            @Override
            public boolean isCacheable(String expressionObjectName) {
                return true;
            }
        };
    }
}

