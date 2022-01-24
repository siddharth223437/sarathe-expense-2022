import moment from 'moment';


class DateUtilService {

    getCurrentDate() {
        return moment().format('yyyy-MM-DD');
    }

    getStartDateOfMonth() {
        return moment().startOf('month').format('yyyy-MM-DD');
    }

    getLastDateOfMonth () {
        return  moment().endOf('month').format('yyy-MM-DD');
    }

    getLastDateOfYear () {
        const date =  this.getCurrentYear()+'-12-31';
        return this.format(date);
    }

    getFirstDateOfYear () {
        const date =  this.getCurrentYear()+'-01-01';
        return this.format(date);
    }

    getCurrentYear() {
        return moment().year();
    }

    getCurrentMonthAsNumber(){
        return moment().month();
    }

    /*month in moment starts from 0-11 */
    getAllMonths() {
        return [
            {id:0,month:'January'},
            {id:1,month:'February'},
            {id:2,month:'March'},
            {id:3,month:'April'},
            {id:4,month:'May'},
            {id:5,month:'June'},
            {id:6,month:'July'},
            {id:7,month:'August'},
            {id:8,month:'September'},
            {id:9,month:'October'},
            {id:10,month:'November'},
            {id:11,month:'December'},
        ]

    }

   format(date) {
        return moment(date).format('yyyy-MM-DD');
   }

   formatWithPattern(date, pattern) {
       return moment(date).format(pattern);
    }

    getCurrentMonthAsString() {
        for(let m of this.getAllMonths()) {
            if(m.id === this.getCurrentMonthAsNumber()) {
                return m.month;
            }
        }
    }

    getMonthAsMomentNumber(month) {
        for(let m of this.getAllMonths()) {
            if(m.month === month) {
                return m.id;
            }
        }
    }

    getMonthAsNumber(month) {
        for(let m of this.getAllMonths()) {
            if(m.month === month) {
                const asNum = m.id + 1;
                if(m.id === 0 || m.id === 1 || m.id === 2 || m.id === 3 || m.id === 4 || m.id === 5||m.id === 6||m.id === 7||m.id === 8||m.id === 9) {
                    //prefix with 0
                   return '0'+asNum;
                }else{
                    return asNum;
                }
            }
        }
    }

    getLastDayOfMonth(sourceDate) {
        return moment(sourceDate).daysInMonth()
    }

    testMoment() {
        return moment('20220101').format('yyyy-MM-DD')
    }

    getLastDateOfYearFromSourceDate(date) {
        return moment(date,'yyyy-MM-DD').year();
    }



}

export default new DateUtilService();