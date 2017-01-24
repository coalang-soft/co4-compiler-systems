package coalang.compile.systems;

import io.github.coalangsoft.lang.context.CompileContext;
import io.github.coalangsoft.lang.context.CompileSystem;
import io.github.coalangsoft.lang.token.TokenType;
import io.github.coalangsoft.lang.tree.TreeItem;

public class SemicolonSystem implements CompileSystem{

	@Override
	public boolean accept(CompileContext context, TreeItem item, boolean asValue) {
		if(item.length() != 1){
			return false;
		}
		return item.at(0).getTokens().getTypes().atOrDefault(0, null) == TokenType.SEMICOLON;
	}

	@Override
	public String compile(CompileContext context, TreeItem item, boolean asValue) {
		return "pop";
	}

}
