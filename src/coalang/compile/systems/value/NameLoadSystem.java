package coalang.compile.systems.value;

import coalang.compile.systems.DotSystem;
import coalang.compile.systems.KeywordSystem;
import io.github.coalangsoft.lang.context.CompileContext;
import io.github.coalangsoft.lang.token.TokenType;
import io.github.coalangsoft.lang.tree.TreeItem;
import io.github.coalangsoft.lib.data.ImutablePair;
import io.github.coalangsoft.lib.data.Pair;

public class NameLoadSystem extends ValueSystem{
	
	public boolean accept(CompileContext context, TreeItem item) {
		if(item.length() != 1){
			return false;
		}
		return item.at(0).getTokens().getTypes().atOrDefault(0, null) == TokenType.NAME;
	}

	@Override
	public Pair<String, Boolean> handle(CompileContext context, String val) {
		if(context.getLastSystem() == KeywordSystem.VAR){
			return new ImutablePair<String, Boolean>("reserve " + val,true);
		}else if(context.getLastSystem() instanceof DotSystem){
			return new ImutablePair<String, Boolean>("get " + val, false);
		}
		return new ImutablePair<String, Boolean>("load " + val, false);
	}
	
}
