package proof;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public class Main {

  public static void main(String[] args) throws Exception {

    try {

      Configuration cfg = new Configuration(new Version(2, 3, 23));
      cfg.setClassForTemplateLoading(Main.class, "templates");

      cfg.setDefaultEncoding("UTF-8");
      cfg.setLocale(Locale.US);
      cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

      // Prepare the template input:
      Map<String, Object> input = new HashMap<String, Object>();
      
      List<FieldItem> fields = new ArrayList<FieldItem>();
      fields.add(new FieldItem("field_1_id", "field1", "Boolean"));
      fields.add(new FieldItem("field_2_id", "field2", "String"));
      
      input.put("fields", fields);

      Template template = cfg.getTemplate("show.ftl");

      Writer consoleWriter = new OutputStreamWriter(System.out);
      template.process(input, consoleWriter);
      Writer fileWriter = new FileWriter(new File("show.html"));
      template.process(input, fileWriter);
      fileWriter.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
} 

