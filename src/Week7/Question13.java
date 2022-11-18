package Week7;

public class Question13 {

    public record Date( int month, int day, int year){

        public Date{
            if(month < 1 || month > 12){
                throw new IllegalArgumentException("Out of Month value.");
            }

            int maxDay = convertMonth(month);

            if ( day < 1 || day > maxDay){
                throw new IllegalArgumentException("Out of Day value.");
            }
        }

        public String covertString(){
            return String.format("%d/%d?%d", month,day,year);
        }

        private int convertMonth(int month) {
            switch (month){
                case 1, 3, 5, 7, 8, 10, 12 : return 31;
                case 2 : {
                    if(year%4 == 0 ){
                        return 29;
                    }else {
                        return 28;
                    }
                }

            }
            return month;
        }
    }
}
