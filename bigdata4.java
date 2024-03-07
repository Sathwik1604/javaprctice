import org.apache.hadoop.*;
public class BigData4 {   
    // Mapper Class
    public static class TupleMapper extends Mapper<LongWritable, Text, NullWritable, Text> {
        public void map(LongWritable key, Text value, Context context) {
            String[] attributes = value.toString().split(",");
            int attribute_A = Integer.parseInt(attributes[0]); 
            if (attribute_A > 100) {
                try {
                    context.write(NullWritable.get(), value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
   // Reducer Class
    public static class TupleReducer extends Reducer<NullWritable, Text, Text, NullWritable> {
        public void reduce(NullWritable key, Iterable<Text> values, Context context) {
            for (Text value : values) {
                try {
                    context.write(value, NullWritable.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "TupleFilterJob"); // Renamed the job to TupleFilterJob
        job.setJarByClass(BigData4.class);
        job.setMapperClass(TupleMapper.class);
        job.setReducerClass(TupleReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
