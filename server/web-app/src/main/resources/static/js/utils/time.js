Date.prototype.format = function (fmt) { //author: meizz
    const o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds().toString().padStart(3, "0") //毫秒
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    return fmt;
}

function nanoFormat(nanoTime, fractionDigits) {
    return timeFormat(nanoTime, fractionDigits, ['ns', 'us', 'ms', 's']);
}

function microFormat(milliTime, fractionDigits) {
    return timeFormat(milliTime, fractionDigits, ['us', 'ms', 's'])
}

function milliFormat(milliTime, fractionDigits) {
    return timeFormat(milliTime, fractionDigits, ['ms', 's'])
}

function timeFormat(time, fractionDigits, units) {
    let val = +time || 0;
    let index = 0;
    if (val <= 0) return '0';
    while (val >= 1000 && index < units.length - 1) {
        index += 1;
        val = time / (1000 ** index);
    }
    if (index == 0) {
        // no need to toFixed(), since it always adds fraction part to the string even if the value is integer
        return val.valueOf() + units[index];
    } else {
        return val.toFixed(fractionDigits === undefined ? 2 : fractionDigits) + units[index];
    }
}