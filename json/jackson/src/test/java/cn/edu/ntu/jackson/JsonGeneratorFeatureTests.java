package cn.edu.ntu.jackson;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;

import static com.fasterxml.jackson.core.JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS;

/**
 * @author zack <br>
 * @create 2020-09-08 21:16 <br>
 * @project json <br>
 */
public class JsonGeneratorFeatureTests {

  /**
   * AUTO_CLOSE_TARGET
   *
   * @throws IOException
   */
  @Test
  public void testAutoCloseTarget() throws IOException {
    JsonFactory factory = new JsonFactory();
    try (JsonGenerator jsonGenerator = factory.createGenerator(System.err, JsonEncoding.UTF8)) {}

    // jsonGenerator io will be closed automatically
  }

  @Test
  public void testAutoCloseTarget2() throws IOException {
    JsonFactory factory = new JsonFactory();
    //  PrintStream is Closeable, so it will be closed automatically by try-with-resources.
    try (PrintStream err = System.err;
        JsonGenerator jg = factory.createGenerator(err, JsonEncoding.UTF8)) {
      // set AUTO_CLOSE_TARGET to false
      jg.disable(JsonGenerator.Feature.AUTO_CLOSE_TARGET);

      // doSomething
    }
  }

  /**
   * Call JsonGenerator close() or flush() method, it will flush data to disk.
   *
   * @throws IOException
   */
  @Test
  public void testFlushPassed2Stream() throws IOException {
    JsonFactory factory = new JsonFactory();
    JsonGenerator jg = factory.createGenerator(System.err, JsonEncoding.UTF8);

    jg.writeStartObject();
    jg.writeStringField("name", "zack");
    jg.writeEndObject();

    jg.close(); // jg.flush();
  }

  /**
   * Should ensure json is complete.
   *
   * @throws IOException
   */
  @Test
  @Deprecated
  public void testAutoCloseJsonContent() throws IOException {
    JsonFactory factory = new JsonFactory();
    try (JsonGenerator jg = factory.createGenerator(System.err, JsonEncoding.UTF8)) {
      jg.writeStartObject();
      jg.writeFieldName("names");
      // arrays
      jg.writeStartArray();
      jg.writeString("zack");
      jg.writeString("timothy");
    }
  }

  /**
   * // {arrays:[3,4,5]}
   *
   * @throws IOException
   */
  @Test
  public void testQuoteFieldNames() throws IOException {
    JsonFactory factory = new JsonFactory();
    try (JsonGenerator jg = factory.createGenerator(System.err, JsonEncoding.UTF8)) {

      // jg.disable(QUOTE_FIELD_NAMES); // {arrays:[3,4,5]}

      jg.writeStartObject();
      jg.writeFieldName("arrays");
      jg.writeArray(new int[] {1, 2, 3, 4, 5, 6}, 2, 3);

      jg.writeEndObject();
    }
  }

  /**
   * 0.9 1.9 "NaN" "-Infinity" "Infinity"
   *
   * @throws IOException
   */
  @Test
  public void testQuoteNonNumericNumbers() throws IOException {
    JsonFactory factory = new JsonFactory();
    try (JsonGenerator jg = factory.createGenerator(System.err, JsonEncoding.UTF8)) {
      // 0.9 1.9 NaN -Infinity Infinity // and it is invalid json
      // jg.disable(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS);

      jg.writeNumber(0.9);
      jg.writeNumber(1.9);

      jg.writeNumber(Float.NaN);
      jg.writeNumber(Float.NEGATIVE_INFINITY);
      jg.writeNumber(Float.POSITIVE_INFINITY);
    }
  }

  /**
   * "zack 好人"
   *
   * @throws IOException
   */
  @Test
  public void testEscapeNonAscii() throws IOException {
    JsonFactory factory = new JsonFactory();
    try (JsonGenerator jg = factory.createGenerator(System.err, JsonEncoding.UTF8)) {
      // jg.enable(ESCAPE_NON_ASCII); // "zack \u597D\u4EBA"
      jg.writeString("zack 好人");
    }
  }

  /**
   * 9223372036854775807
   *
   * @throws IOException
   */
  @Test
  public void testWriteNumbersAsStrings() throws IOException {
    JsonFactory factory = new JsonFactory();
    try (JsonGenerator jg = factory.createGenerator(System.err, JsonEncoding.UTF8)) {
      // jg.enable(WRITE_NUMBERS_AS_STRINGS); // "9223372036854775807"

      Long num = Long.MAX_VALUE;
      jg.writeNumber(num);
    }
  }

  /**
   * 1 1.0 1E+11
   *
   * @throws IOException
   */
  @Test
  public void testWriteBigDecimalAsPlain() throws IOException {
    JsonFactory factory = new JsonFactory();
    try (JsonGenerator jg = factory.createGenerator(System.err, JsonEncoding.UTF8)) {
      // jg.enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN);  //1 1.0 100000000000

      BigDecimal bigDecimal1 = new BigDecimal(1.0);
      BigDecimal bigDecimal2 = new BigDecimal("1.0");
      BigDecimal bigDecimal3 = new BigDecimal("1E11");
      jg.writeNumber(bigDecimal1);
      jg.writeNumber(bigDecimal2);
      jg.writeNumber(bigDecimal3);
    }
  }

  /**
   * {"name":"YourBatman","name":"zack"}
   *
   * @throws IOException
   */
  @Test
  public void testStrictDuplicateDetection() throws IOException {
    JsonFactory factory = new JsonFactory();
    try (JsonGenerator jg = factory.createGenerator(System.err, JsonEncoding.UTF8)) {
      // com.fasterxml.jackson.core.JsonGenerationException: Duplicate field 'name'
      // jg.enable(JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION);

      jg.writeStartObject();
      jg.writeStringField("name", "YourBatman");
      jg.writeStringField("name", "zack");
      jg.writeEndObject();
    }
  }
}
