package suanfa;

import java.util.Arrays;

public class Main_贪心_区间调度 {
    //1.时间表排序,区间调度问题
    //课程	开始时间	结束时间
    //美术	  9AM	       10AM
    //英语	  9:30AM	   10:30AM
    //数学	  10AM	       11AM
    //计算机  10:30AM	   11:30AM
    //音乐 	  11AM	       12PM
    //算法设计：
    //   如果被检查的活动i的开始时间小于最近选择的活动j的结束时间，则不选择活动i,否则选择活动i
    // 1.选择结束最早的课，便是要在这教室上课的第一节课
    // 2.选择第一堂课结束后才开始的课，并且结束最早的课，这将是第二节在教室上的课。
    public static void main(String[] args) {
        String subject[] = {"英语", "数学", "计算机", "音乐", "美术"};
        Work[] works = {
                new Work(1, 3),
                new Work(2, 5),
                new Work(4, 7),
                new Work(6, 9),
                new Work(8, 10)
        };
        int result = solution(works);
        System.out.println(result);
//        solution(subject,5,start,end);
    }

    private static int solution(Work[] works) {
        //works里面已经按end从小到大排序了
        Arrays.sort(works);
        int count = 0;
        //当前工作的结束时间
        int endTime = 0;
        for (int i = 0; i < works.length; i++) {
            if (endTime < works[i].getStart()) {
                count++;
                endTime = works[i].getEnd();
            }
        }
        return count;
    }

    static class Work implements Comparable {
        private int start;
        private int end;

        public Work(int start, int end) {
            this.start = start;
            this.end = end;
        }

        //end 从小到大排序
        @Override
        public int compareTo(Object o) {
            Work work = (Work) o;
            if (this.end > work.getEnd()) {
                return 1;
            } else if (this.end == work.getEnd()) {
                return 0;
            } else {
                return -1;
            }
        }

        public int getStart() {
            return start;
        }


        public int getEnd() {
            return end;
        }


    }

}
