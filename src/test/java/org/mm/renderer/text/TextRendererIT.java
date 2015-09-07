package org.mm.renderer.text;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mm.core.settings.ReferenceSettings;
import org.mm.parser.ParseException;
import org.mm.renderer.RendererException;
import org.mm.rendering.text.TextRendering;
import org.mm.ss.SpreadsheetLocation;
import org.mm.test.IntegrationTestBase;

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
  }
}
