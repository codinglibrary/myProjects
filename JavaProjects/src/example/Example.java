package example;

public class Example {
    public static void main(String args[]){
        trans();
    }

    public static void trans(){
        String sourcePath = "R:\\LearningNotes\\images";
        String sourceName = "sofa框架";
        String sourceFormat = "png";
        String destinationPath = "R:\\LearningNotes";
        //String destinationFormat = "png";
        Transcoding.transcode(sourcePath,sourceName,sourceFormat,sourceName);
    }
}
