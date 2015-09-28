package org.metadatacenter.jsonss.renderer.text;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.metadatacenter.jsonss.core.settings.ReferenceSettings;
import org.metadatacenter.jsonss.exceptions.JSONSSException;
import org.metadatacenter.jsonss.parser.ParseException;
import org.metadatacenter.jsonss.rendering.text.TextRendering;
import org.metadatacenter.jsonss.test.IntegrationTestBase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class TextRendererIT extends IntegrationTestBase
{
  private ReferenceSettings settings;

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Before public void setUp()
  {
    settings = new ReferenceSettings();
  }

  @Test public void TestEmptyObject() throws ParseException, IOException, JSONSSException
  {
    String expression = "{}";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestEmptyArray() throws ParseException, IOException, JSONSSException
  {
    String expression = "[]";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestEmptyStringValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "{\"key\": \"\"}";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestNonEmptyStringValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "{\"key\": \"value\"}";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestBooleanTrueValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "{\"key\": true}";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestBooleanFalseValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "{\"key\": false}";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestNullValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "{\"key\": null}";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestIntegerValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "{\"key\": 23}";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestFloatValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "{\"key\": 23.43}";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestEmptyStringElementValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "[\"\"]";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestNonEmptyStringElementValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "[\"value\"]";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestIntegerElementValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "[23]";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestFloatElementValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "[23.34]";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestBooleanTrueElementValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "[true]";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestBooleanFalseElementValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "[false]";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestNullElementValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "[null]";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestEmptyObjectElementValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "[{}]";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestNonEmptyObjectElementValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "[{\"key\": 23}]";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestEmptyArrayElementValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "[[]]";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestNonEmptyArrayElementValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "[[23]]";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestEmptyObjectValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "{\"key\": {}}";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestNonEmptyObjectValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "{\"key\": {\"key2\": 23}}";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestEmptyArrayValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "{\"key\": []}";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestNonEmptyArrayValue() throws ParseException, IOException, JSONSSException
  {
    String expression = "{\"key\": [23]}";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestMultipleObjectValues() throws ParseException, IOException, JSONSSException
  {
    String expression = "{\"key1\": 23, \"key2\": 23.45, \"key3\": null, \"key4\": {}, \"key5\": \"\", \"key6\": true, \"key7\": false, \"key8\": []}";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestMultipleArrayValues() throws ParseException, IOException, JSONSSException
  {
    String expression = "[23, 23.45, null, {}, \"\", true, false, []]";

    Optional<? extends TextRendering> textRendering = createTextRendering(expression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expression, textRendering.get().getRendering());
  }

  @Test public void TestLiteralStringReference() throws ParseException, IOException, JSONSSException
  {
    String inputExpression = "{\"hasCar\": @\"BMW\"}";
    String expectedExpression = "{\"hasCar\": \"BMW\"}";

    Optional<? extends TextRendering> textRendering = createTextRendering(inputExpression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expectedExpression, textRendering.get().getRendering());
  }

  @Test public void TestStringReference() throws ParseException, IOException, JSONSSException
  {
    String inputExpression = "{\"hasCar\": @A1}";
    String expectedExpression = "{\"hasCar\": \"BMW\"}";
    Label cellA1 = createCell("BMW", 1, 1);
    Set<Label> cells = createCells(cellA1);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);

    Optional<? extends TextRendering> textRendering = createTextRendering(SHEET1, cells, inputExpression, settings);

    Assert.assertTrue(textRendering.isPresent());
    Assert.assertEquals(expectedExpression, textRendering.get().getRendering());
  }

  @Test public void TestQualifiedStringReference() throws ParseException, IOException
  {
    String inputExpression = "{ \"hasCar\": @A1(string) }";
    String expectedExpression = "{ \"hasCar\": \"BMW\" }";
    Label cellA1 = createCell("BMW", 1, 1);
    Set<Label> cells = createCells(cellA1);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);
  }

  @Test public void TestIntegerReference() throws ParseException, IOException
  {
    String inputExpression = "{ \"hasAge\": @A1(integer) }";
    String expectedExpression = "{ \"hasAge\": 33 }";
    Label cellA1 = createCell("33", 1, 1);
    Set<Label> cells = createCells(cellA1);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);
  }

  @Test public void TestNumberReference() throws ParseException, IOException
  {
    String inputExpression = "{ \"hasHeight\": @A1(number) }";
    String expectedExpression = "{ \"hasHeight\": 33.3 }";
    Label cellA1 = createCell("33.3", 1, 1);
    Set<Label> cells = createCells(cellA1);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);
  }

  @Test public void TestBooleanReference() throws ParseException, IOException
  {
    String inputExpression = "{ \"isFrench\": @A1(boolean) }";
    String expectedExpression = "{ \"isFrench\": true }";
    Label cellA1 = createCell("true", 1, 1);
    Set<Label> cells = createCells(cellA1);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);
  }

  @Test public void TestStringReferenceRange() throws ParseException, IOException
  {
    String inputExpression = "{ \"hasAliases\": @A1:A2 }";
    String expectedExpression = "{ \"hasAliases\": [ \"Bob\", \"Bobby\" ] }";
    Label cellA1 = createCell("Bob", 1, 1);
    Label cellA2 = createCell("Bobby", 1, 1);
    Set<Label> cells = createCells(cellA1, cellA2);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);
  }

  @Test public void TestExplicitStringReferenceRange() throws ParseException, IOException
  {
    String inputExpression = "{ \"hasAliases\": @A1:A2(string) }";
    String expectedExpression = "{ \"hasAliases\": [ \"Bob\", \"Bobby\" ] }";
    Label cellA1 = createCell("Bob", 1, 1);
    Label cellA2 = createCell("Bobby", 1, 2);
    Set<Label> cells = createCells(cellA1, cellA2);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);
  }

  @Test public void TestIntegerReferenceRange() throws ParseException, IOException
  {
    String inputExpression = "{ \"hasHeights\": @A1:A2(integer) }";
    String expectedExpression = "{ \"hasHeights\": [ 44, 55 ] }";
    Label cellA1 = createCell("44", 1, 1);
    Label cellA2 = createCell("55", 1, 2);
    Set<Label> cells = createCells(cellA1, cellA2);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);
  }

  @Test public void TestNumberReferenceRange() throws ParseException, IOException
  {
    String inputExpression = "{ \"hasHeights\": @A1:A2(number) }";
    String expectedExpression = "{ \"hasHeights\": [ 44.1, 55.4 ] }";
    Label cellA1 = createCell("44.1", 1, 1);
    Label cellA2 = createCell("55.4", 1, 2);
    Set<Label> cells = createCells(cellA1, cellA2);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);
  }

  @Test public void TestBooleanReferenceRange() throws ParseException, IOException
  {
    String inputExpression = "{ \"switchPositions\": @A1:A2(boolean) }";
    String expectedExpression = "{ \"switchPositions\": [ true, false ] }";
    Label cellA1 = createCell("true", 1, 1);
    Label cellA2 = createCell("false", 1, 2);
    Set<Label> cells = createCells(cellA1, cellA2);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);
  }

  @Test public void TestObjectReferenceRange() throws ParseException, IOException
  {
    String inputExpression = "{ \"people\": { \"@range\": @A1:A2, \"name\": @A*, \"age\": @B*(integer) } }";
    String expectedExpression = "{ \"people\": [" +
        "{ \"name\": \"Bob\", \"age\": 23 }, " +
        "{ \"name\": \"Fred\", \"age\": 33 } ] }";
    Label cellA1 = createCell("Bob", 1, 1);
    Label cellA2 = createCell("Fred", 1, 2);
    Label cellB1 = createCell("23", 2, 1);
    Label cellB2 = createCell("33", 2, 2);
    Set<Label> cells = createCells(cellA1, cellA2, cellB1, cellB2);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);
  }

}
