package coalang.compile.systems.value;

import io.github.coalangsoft.lang.context.CompileContext;
import io.github.coalangsoft.lang.token.TokenType;
import io.github.coalangsoft.lang.tree.TreeItem;
import io.github.coalangsoft.lib.data.ImutablePair;
import io.github.coalangsoft.lib.data.Pair;

public class NumberSystem extends ValueSystem{

	@Override
	public boolean accept(CompileContext context, TreeItem item) {
		if(item.length() != 1){
			return false;
		}
		return item.at(0).getTokens().getTypes().atOrDefault(0, null) == TokenType.NUMBER;
	}

	@Override
	public Pair<String, Boolean> handle(CompileContext context, String val) {
		return new ImutablePair<String, Boolean>("putI " + val, false);
	}

}
