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

  @Before public void setUp()
  {
    settings = new ReferenceSettings();
  }

  @Test public void TestLiteralStringReference() throws ParseException, IOException
  {
    String inputExpression = "{ \"hasCar\": @\"BMW\" }";
    String outputExpression = "{ \"hasCar\": \"BMW\" }";
  }

  @Test public void TestStringReference() throws ParseException, IOException
  {
    String inputExpression = "{ \"hasCar\": @A1 }";
    String outputExpression = "{ \"hasCar\": \"BMW\" }";
    Label cellA1 = createCell("BMW", 1, 1);
    Set<Label> cells = createCells(cellA1);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);
  }

  @Test public void TestQualifiedStringReference() throws ParseException, IOException
  {
    String inputExpression = "{ \"hasCar\": @A1(string) }";
    String outputExpression = "{ \"hasCar\": \"BMW\" }";
    Label cellA1 = createCell("BMW", 1, 1);
    Set<Label> cells = createCells(cellA1);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);
  }

  @Test public void TestIntegerReference() throws ParseException, IOException
  {
    String inputExpression = "{ \"hasAge\": @A1(integer) }";
    String outputExpression = "{ \"hasAge\": 33 }";
    Label cellA1 = createCell("33", 1, 1);
    Set<Label> cells = createCells(cellA1);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);
  }

  @Test public void TestNumberReference() throws ParseException, IOException
  {
    String inputExpression = "{ \"hasHeight\": @A1(number) }";
    String outputExpression = "{ \"hasHeight\": 33.3 }";
    Label cellA1 = createCell("33.3", 1, 1);
    Set<Label> cells = createCells(cellA1);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);
  }

  @Test public void TestBooleanReference() throws ParseException, IOException
  {
    String inputExpression = "{ \"isFrench\": @A1(boolean) }";
    String outputExpression = "{ \"isFrench\": true }";
    Label cellA1 = createCell("true", 1, 1);
    Set<Label> cells = createCells(cellA1);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);
  }

  @Test public void TestStringReferenceRange() throws ParseException, IOException
  {
    String inputExpression = "{ \"hasAliases\": @A1:A2 }";
    String outputExpression = "{ \"hasAliases\": [ \"Bob\", \"Bobby\" ] }";
    Label cellA1 = createCell("Bob", 1, 1);
    Label cellA2 = createCell("Bobby", 1, 1);
    Set<Label> cells = createCells(cellA1, cellA2);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);
  }

  @Test public void TestExplicitStringReferenceRange() throws ParseException, IOException
  {
    String inputExpression = "{ \"hasAliases\": @A1:A2(string) }";
    String outputExpression = "{ \"hasAliases\": [ \"Bob\", \"Bobby\" ] }";
    Label cellA1 = createCell("Bob", 1, 1);
    Label cellA2 = createCell("Bobby", 1, 2);
    Set<Label> cells = createCells(cellA1, cellA2);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);
  }

  @Test public void TestIntegerReferenceRange() throws ParseException, IOException
  {
    String inputExpression = "{ \"hasHeights\": @A1:A2(integer) }";
    String outputExpression = "{ \"hasHeights\": [ 44, 55 ] }";
    Label cellA1 = createCell("44", 1, 1);
    Label cellA2 = createCell("55", 1, 2);
    Set<Label> cells = createCells(cellA1, cellA2);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);
  }

  @Test public void TestNumberReferenceRange() throws ParseException, IOException
  {
    String inputExpression = "{ \"hasHeights\": @A1:A2(number) }";
    String outputExpression = "{ \"hasHeights\": [ 44.1, 55.4 ] }";
    Label cellA1 = createCell("44.1", 1, 1);
    Label cellA2 = createCell("55.4", 1, 2);
    Set<Label> cells = createCells(cellA1, cellA2);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);
  }

  @Test public void TestBooleanReferenceRange() throws ParseException, IOException
  {
    String inputExpression = "{ \"switchPositions\": @A1:A2(boolean) }";
    String outputExpression = "{ \"switchPositions\": [ true, false ] }";
    Label cellA1 = createCell("true", 1, 1);
    Label cellA2 = createCell("false", 1, 2);
    Set<Label> cells = createCells(cellA1, cellA2);
    Map<String, Set<Label>> ss = new HashMap<>();
    ss.put(SHEET1, cells);
  }

  @Test public void TestObjectReferenceRange() throws ParseException, IOException
  {
    String inputExpression = "{ \"people\": { \"@range\": @A1:A2, \"name\": @A*, \"age\": @B*(integer) } }";
    String outputExpression = "{ \"people\": [" +
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
