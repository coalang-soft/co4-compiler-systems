package coalang.compile.systems;

import io.github.coalangsoft.lang.context.CompileContext;
import io.github.coalangsoft.lang.context.CompileSystem;
import io.github.coalangsoft.lang.token.TokenType;
import io.github.coalangsoft.lang.tree.TreeItem;

public class NameLoadSystem implements CompileSystem{

	private static final String VAR_HINT = "var";

	public boolean accept(CompileContext context, TreeItem item, boolean asValue) {
		if(item.length() != 1){
			return false;
		}
		return item.at(0).getTokens().getTypes().atOrDefault(0, null) == TokenType.NAME;
	}

	public String compile(CompileContext context, TreeItem item, boolean asValue) {
		String name = item.at(0).getTokens().at(0).getValue();
		if(context.getLastSystem() instanceof DotSystem){
			return "get " + name;
		}
		if(name.equals("var")){
			context.requireNext(getClass());
		}
		return "load " + name;
	}
	
}
