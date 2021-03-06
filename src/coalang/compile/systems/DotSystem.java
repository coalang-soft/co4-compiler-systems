package coalang.compile.systems;

import io.github.coalangsoft.lang.context.CompileContext;
import io.github.coalangsoft.lang.context.CompileSystem;
import io.github.coalangsoft.lang.token.TokenType;
import io.github.coalangsoft.lang.tree.TreeItem;

public class DotSystem implements CompileSystem{
	
	public static final String MARK = "dot";
	
	public boolean accept(CompileContext context, TreeItem item) {
		if(item.length() != 1){
			return false;
		}
		return item.at(0).getTokens().getTypes().atOrDefault(0, null) == TokenType.DOT;
	}

	public String compile(CompileContext context, TreeItem item) {
		context.sendHint(MARK);
		return "";
	}
	
}
