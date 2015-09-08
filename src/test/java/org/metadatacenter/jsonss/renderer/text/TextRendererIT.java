package org.metadatacenter.jsonss.renderer.text;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.metadatacenter.jsonss.core.settings.ReferenceSettings;
import org.metadatacenter.jsonss.parser.ParseException;
import org.metadatacenter.jsonss.test.IntegrationTestBase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TextRendererIT extends IntegrationTestBase
{
  private ReferenceSettings settings;

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() 
  {
    settings = new ReferenceSettings();
  }

  @Test public void TestTest()
      throws ParseException, IOException
  {
    Label cellA1 = createCell("BMW", 1, 1);
    Set<Label> cells = createCells(cellA1);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);

    String expression = "{ \"hasCar\": @A1 }";
//    Optional<TextRendering> rendering = createTextRendering(ss, expression, settings);
//    assertThat(rendering.isPresent(), is(true));
  }
}
