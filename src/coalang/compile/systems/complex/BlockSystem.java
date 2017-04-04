package coalang.compile.systems.complex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import coalang.compile.systems.CommaSystem;

import io.github.coalangsoft.lang.context.CompileContext;
import io.github.coalangsoft.lang.tree.TreeItem;
import io.github.coalangsoft.lang.tree.TreeItemType;

public class BlockSystem extends ComplexSystem{
	
	private int counter = 0;
	
	@Override
	public boolean accept(CompileContext context, TreeItem item) {
		if(item.length() != 1){
			return false;
		}
		return item.at(0).getType() == TreeItemType.BLOCK;
	}

	@Override
	public String handleResult(CompileContext c, String s) {
		File f = new File("f" + (counter++) + ".cl0");
		String add = "";
		if(c.hasHint(CommaSystem.MARK)){
			add = "invoke 1\n";
		}
		try {
			FileWriter w = new FileWriter(f);
			w.write(s);
			if(!s.trim().isEmpty()){
				w.write("\n");
			}
			w.write(add + "ret");
			w.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return "putM " + f.getName();
	}
	
}
