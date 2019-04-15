package de.tudresden.inf.st.most;

import beaver.Parser;
import de.tudresden.inf.st.most.deserializer.ASTNodeDeserializer;
import de.tudresden.inf.st.most.jastadd.ast.Def;
import de.tudresden.inf.st.most.jastadd.ast.Root;
import de.tudresden.inf.st.most.jastadd.parser.ExpressionParser;
import de.tudresden.inf.st.most.jastadd.scanner.ExpressionScanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * Main test entry point for exercise.
 * Created by rschoene on 10/25/17.
 */
public class ExerciseMain {

	/**
	 * loads an expression language model
	 * @param fileName either a json file with a .json file extension or a DSL file with an .exp extension.
	 * @return an abstract syntax tree
	 * @throws IOException if the file could not be loaded
	 * @throws Parser.Exception if the parser could not parse the DSL file
	 */
	public static Root load(String fileName) throws IOException, Parser.Exception {
		URL expUrl = ExerciseMain.class.getClassLoader().getResource(fileName);
		File file = null;
		if (expUrl != null) {
			file = new File(expUrl.getFile());
		} else {
			file = new File(fileName);
		}
		if (file == null) {
			throw new FileNotFoundException("Could not load JSON file " + fileName);
		}

		if (fileName.endsWith(".json")) {
			System.out.println("Loading JSON file '" + fileName + "'.");
			return ASTNodeDeserializer.read(file);
		} else {
			System.out.println("Loading expression DSL file '" + fileName + "'.");
			FileReader reader = new FileReader(file);
			ExpressionScanner scanner = new ExpressionScanner(reader);
			ExpressionParser parser = new ExpressionParser();
			return (Root) parser.parse(scanner);
		}
	}

	// required for the DrAST debugger
	public static Object DrAST_root_node;

	/**
	 * Main method of the exercise. Change the file name to test with other files. Comment in the respective parts after
	 * solving a task.
	 */
	public static void main(String[] args) throws IOException, Parser.Exception {
		Root root;

		String fileName = "generatedBegin.exp";

		if(args.length > 0) {
			fileName = args[0];
		}

		root = load(fileName);


		System.out.println("\n\nThe AST before any rewrites were triggered");
		System.out.println(root.getASTString());

		System.out.println("\n\nTrigger rewrites... ");
		root.doFullTraversal(); // only required if no attribute should be evaluated

		System.out.println("\n\nThe AST after all rewrites were triggered");
		System.out.println("\n\n" + root.getASTString());

//		System.out.println("\n\nroot.getExp().eval() = " + root.getExp().eval());

		System.out.println(root.print());

//		System.out.println("\n\nAnd now some analysis:");
//		System.out.print("    Unused definitions: ");
//		for (Def def : root.unusedDefs()) {
//			System.out.print(def.getName() + "=" + def.getValue() + " ");
//		}
//		System.out.println();


		// required for the DrAST debugger
		DrAST_root_node = root;
	}
}
