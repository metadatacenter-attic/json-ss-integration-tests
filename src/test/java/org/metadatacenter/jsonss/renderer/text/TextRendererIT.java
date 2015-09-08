package org.metadatacenter.jsonss.renderer.text;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.metadatacenter.jsonss.core.settings.ReferenceSettings;
import org.metadatacenter.jsonss.parser.ParseException;
import org.metadatacenter.jsonss.test.IntegrationTestBase;

import java.io.IOException;

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
