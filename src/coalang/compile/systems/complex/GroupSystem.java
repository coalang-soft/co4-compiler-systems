package coalang.compile.systems.complex;

import io.github.coalangsoft.lang.context.CompileContext;
import io.github.coalangsoft.lang.tree.TreeItem;
import io.github.coalangsoft.lang.tree.TreeItemType;

public class GroupSystem extends ComplexSystem {

	@Override
	public boolean accept(CompileContext context, TreeItem item) {
		if(item.length() != 1){
			return false;
		}
		return item.at(0).getType() == TreeItemType.GROUP;
	}

	@Override
	public String handleResult(CompileContext c, String s) {
		if(s.isEmpty()){
			return "invoke 0";
		}
		return s + "\ninvoke 1";
	}

}
