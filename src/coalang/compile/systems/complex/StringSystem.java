package coalang.compile.systems.complex;

import io.github.coalangsoft.lang.context.CompileContext;
import io.github.coalangsoft.lang.context.CompileSystem;
import io.github.coalangsoft.lang.tree.TreeItem;
import io.github.coalangsoft.lang.tree.TreeItemType;
import io.github.coalangsoft.lang.visit.StandardVisitor;

public class StringSystem implements CompileSystem {

	@Override
	public boolean accept(CompileContext context, TreeItem item) {
		if(item.length() != 1){
			return false;
		}
		return item.at(0).getType() == TreeItemType.STRING;
	}

	@Override
	public String compile(CompileContext context, TreeItem item) {
		TreeItem it = new TreeItem(null);
		for(int i = 1; i < item.at(0).length()-1; i++){
			it.add(item.at(0).at(i));
		}
		StringBuilder b = new StringBuilder();
		createString(it,b);
		return "putS " + b.toString();
	}

	private void createString(TreeItem it, StringBuilder b) {
		for(int i = 0; i < it.length(); i++){
			TreeItem ti = it.at(i);
			if(ti.getType() == TreeItemType.TOKEN){
				b.append(ti.getTokens().at(0).getValue());
			}else{
				createString(ti,b);
			}
		}
	}
	
}
