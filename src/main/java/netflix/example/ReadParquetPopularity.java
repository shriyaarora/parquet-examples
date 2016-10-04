package netflix.example;

import org.apache.avro.Schema;
import org.apache.avro.reflect.ReflectData;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.avro.AvroParquetReader;
import org.apache.parquet.avro.AvroReadSupport;
import org.apache.parquet.hadoop.ParquetReader;

public class ReadParquetPopularity {
  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Path dataFile = new Path("src/main/resources/language_pops.gz.parquet");

    Schema schema = ReflectData.AllowNull.get().getSchema(PopularityData.class);
    AvroReadSupport.setAvroReadSchema(conf,schema);
    AvroReadSupport.setRequestedProjection(conf,schema);

    // Read Pojos from a Parquet file
    try (ParquetReader<PopularityData> reader = AvroParquetReader.<PopularityData>builder(dataFile)
        .withDataModel(new ReflectData(PopularityData.class.getClassLoader()))
        .disableCompatibility() // always use this (since this is a new project)
        .withConf(conf)
        .build()) {

      PopularityData pojo;
      while ((pojo = reader.read()) != null) {
        System.err.println("All records: " + pojo.getLanguage());
      }
    }


  }
}
