package de.tudresden.inf.st.most;

import beaver.Parser;
import de.tudresden.inf.st.most.ExerciseMain;
import de.tudresden.inf.st.most.jastadd.ast.Number;
import de.tudresden.inf.st.most.jastadd.ast.Root;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class JastaddTest {

  private static final double DELTA = 1e-5;

  @Test
  public void testTask0() throws IOException, Parser.Exception {
    // load the files
    Root root1 = ExerciseMain.load("generatedBegin.json");
    Root root2 = ExerciseMain.load("generatedBegin.exp");

    // compare the ASTs (before any rewrites)
    Assert.assertEquals(root1.getASTString(), root2.getASTString());

    // test print()
    Assert.assertEquals(root1.print(), root2.print());

    // compare the ASTs (alter all rewrites)
    Assert.assertEquals(root1.getASTString(), root2.getASTString());
  }

  @Test
  public void testTask1() throws IOException, Parser.Exception {
    // load the files
    Root root1 = ExerciseMain.load("generatedTask1.json");
    Root root2 = ExerciseMain.load("generatedTask1.exp");

    // compare the ASTs (before any rewrites)
    Assert.assertEquals(root1.getASTString(), root2.getASTString());

    Assert.assertEquals(root1.getExp().eval(),-12.8, DELTA);
    Assert.assertEquals(root2.getExp().eval(),-12.8, DELTA);

    // test print()
    Assert.assertEquals(root1.print(), root2.print());

    // compare the ASTs (alter all rewrites)
    Assert.assertEquals(root1.getASTString(), root2.getASTString());
  }

  @Test
  public void testTask2() throws IOException, Parser.Exception {
    // load the files
    Root root1 = ExerciseMain.load("generatedTask2.json");
    Root root2 = ExerciseMain.load("generatedTask2.exp");

    // compare the ASTs (before any rewrites)
    Assert.assertEquals(root1.getASTString(), root2.getASTString());

    Assert.assertEquals(root1.getExp().eval(),10, DELTA);
    Assert.assertEquals(root2.getExp().eval(),10, DELTA);

    // test print()
    Assert.assertEquals(root1.print(), root2.print());

    // test the rewrites
    Assert.assertTrue(root1.getExp() instanceof Number);
    Assert.assertEquals(((Number)root1.getExp()).getValue(),10, DELTA);
    Assert.assertTrue(root2.getExp() instanceof Number);
    Assert.assertEquals(((Number)root2.getExp()).getValue(),10, DELTA);

    // compare the ASTs (alter all rewrites)
    Assert.assertEquals(root1.getASTString(), root2.getASTString());
  }

  @Test
  public void testTask3() throws IOException, Parser.Exception {
    // load the files
    Root root1 = ExerciseMain.load("generatedTask3.json");
    Root root2 = ExerciseMain.load("generatedTask3.exp");

    // compare the ASTs (before any rewrites)
    Assert.assertEquals(root1.getASTString(), root2.getASTString());

    Assert.assertEquals(root1.getExp().eval(),10, DELTA);
    Assert.assertEquals(root2.getExp().eval(),10, DELTA);

    // test print()
    Assert.assertEquals(root1.print(), root2.print());

    // test unusedDefs()
    // note, that unusedDefs() contains all variables because of the rewrite that simplifies the expression to '10.0'
    Assert.assertEquals(root1.unusedDefs().size(),3);
    Assert.assertTrue(root1.unusedDefs().contains(root1.getDef(0)));
    Assert.assertTrue(root1.unusedDefs().contains(root1.getDef(1)));
    Assert.assertTrue(root1.unusedDefs().contains(root1.getDef(2)));
    Assert.assertEquals(root2.unusedDefs().size(),3);
    Assert.assertTrue(root2.unusedDefs().contains(root2.getDef(0)));
    Assert.assertTrue(root2.unusedDefs().contains(root2.getDef(1)));
    Assert.assertTrue(root2.unusedDefs().contains(root2.getDef(2)));

    // compare the ASTs (alter all rewrites)
    Assert.assertEquals(root1.getASTString(), root2.getASTString());

  }
}