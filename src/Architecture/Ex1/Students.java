package Architecture.Ex1;
import java.io.*;

public class Students {
    private int[] studentsArray;

    public int[] insertGrades(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        int count = 0;
        while ((line = br.readLine()) != null) {
            count++;
        }
        br.close();

        String[] grades = new String[count];
        br = new BufferedReader(new FileReader(fileName));
        int index = 0;

        while ((line = br.readLine()) != null) {
            grades[index++] = line;
        }
        br.close();

        studentsArray = new int[grades.length];

        for (int i = 0; i < grades.length; i++) {
            String studentGrades = grades[i];
            String[] parts = studentGrades.split(",");
            int grade1 = Integer.parseInt(parts[0]);
            int grade2 = Integer.parseInt(parts[1]);
            int grade3 = Integer.parseInt(parts[2]);
            int grade4 = Integer.parseInt(parts[3]);
            studentsArray[i] = (grade4 << 24) | (grade3 << 16) | (grade2 << 8) | grade1;
        }

        return studentsArray;
    }
    public void displayHex() {
        for (int num : studentsArray) {
            System.out.printf("%08X", num);
        }
        System.out.println();
    }
    public int getStudentExam(int i, int j) {
        return (studentsArray[i - 1] >> (8 * (j - 1))) & 0xFF;
    }
    public void setStudentExam(int i, int j, int k) {
        int shift = 8 * (j - 1);
        studentsArray[i - 1] = (studentsArray[i - 1] & ~(0xFF << shift)) | ((k & 0xFF) << shift);
    }
    public float averageStudent(int i) {
        int sum = 0;
        for (int j = 1; j <= 4; j++) {
            sum += getStudentExam(i, j);
        }
        return (float) sum/4;
    }
    public float averageExam(int j) {
        int sum = 0;
        for (int i = 1; i <= studentsArray.length; i++) {
            sum += getStudentExam(i, j);
        }
        return sum/(float)studentsArray.length;
    }
}
