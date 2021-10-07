class ChartComponent {

    constructor(option) {
        this.option = $.extend({
            height: '200px'
        }, option);

        this._chartId = option.containerId + '_chart';
        this._card = $('#' + option.containerId).append(
            '    <div class="card card-block" style="border-radius: .0em !important;">                             ' +
            '        <div class="card-body" style="padding: 0.25em">                    ' +
            '            <div class="card-chart"></div> ' +
            '        </div>                                     ' +
            '    </div>                                         ')
            .find('.card');
        $(this._card).find('.card-chart').attr('id', this._chartId).height(this.option.height);

        this._chart = echarts.init(document.getElementById(this._chartId));
        window.addEventListener("resize", () => {
            this._chart.resize();
        });

        this._openHandler = null;
        this._chartSeries = {};
    }

    header(text) {
        let headerText = $(this._card).find('.header-text');
        if (headerText.length === 0) {
            const header = $(this._card).prepend(
                '<div class="card-header d-flex" style="padding: 0.5em 1em">' +
                '<span class="header-text btn-sm"></span>' +
                '<div class="tools ml-auto">' +
                //'    <button class="btn btn-sm btn-alert"><span class="far fa-bell" title="alert"></span></button>' +
                '</div>' +
                '</div>');

            headerText = header.find('.header-text');
        }
        $(headerText).html(text);
        return this;
    }

    height(height) {
        $(this._card).find('.card-chart').height(height);
        return this;
    }

    title(text) {
        if (this._title == null) {
            this._title = $(this._card).find('.card-body').prepend('<h5 class="card-title">Card title</h5>').find('.card-title');
        }
        $(this._title).html(text);
        return this;
    }

    getOption() {
        return this.option;
    }

    /**
     * {
     *     ajaxType: 'POST',
     *     processResult: function (data){
     *         return echarts_option;
     *     },
     *     url: url,
     *     ajaxData: {},
     *     operation: merge | replace
     * }
     */
    load(option) {
        option = $.extend({
            ajaxType: 'POST',
            processResult: function (data) {
                return data;
            },
        }, option);

        this._chart.showLoading({text: 'Loading...'});

        $.ajax({
            type: option.ajaxType,
            url: option.url,
            async: true,
            data: option.ajaxData,
            dataType: "json",
            contentType: "application/json",
            success: (data) => {
                this._chart.hideLoading();
                const returnedOption = option.processResult(data);
                if (returnedOption.series != null) {
                    //
                    // merge series
                    //
                    $.each(returnedOption.series, (index, s) => {
                        this._chartSeries[s.name] = s;
                    });
                    const series = [];
                    for (const name in this._chartSeries) {
                        series.push(this._chartSeries[name]);
                    }
                    returnedOption.series = series;
                }

                let legend = {
                    data: [],
                    selected: {}
                };
                returnedOption.series.forEach(s=>{
                    legend.data.push({
                        name: s.name,
                        icon: 'circle'
                    });
                    legend.selected[s.name] = s.selected;
                });
                returnedOption.legend = legend;
                this.setChartOption(returnedOption);
            },
            error: (data) => {
                this._chart.hideLoading();
                console.log(data);
            }
        });
    }

    clearLines(name) {
        if (name == null) {
            this._chartSeries = [];
            this.setChartOption({
                legend: {
                    data: []
                },
                series: []
            });
        } else {
            const currentOption = this.getChartOption();
            const newSeries = [];
            const newList = [];
            for (let i = 0; i < currentOption.legend[0].data.length; i++) {
                const legend = currentOption.legend[0].data[i];

                if (legend.name.startsWith(name)) {
                    delete this._chartSeries[legend.name];
                    currentOption.series[i].data = [];
                } else {
                    newList.push(legend);
                }
                newSeries.push(currentOption.series[i]);
            }
            this.setChartOption({
                legend: {
                    data: newList
                },
                series: newSeries
            });
        }
    }

    containsLine(name) {
        for (const s in this._chartSeries) {
            if (s.name === name) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     */
    showLines(option) {
        const charOption = {
            title: {
                text: option.title,
                left: "center",
                textStyle: {
                    fontSize: 14
                }
            },
            color: ['#0098d9', '#90c31d'],
            tooltip: {
                trigger: 'axis'
            },
            grid: [{
                right: '4%',
                left: '4%',
                containLabel: true
            }],
            xAxis: [
                {
                    type: 'category',
                    axisTick: {
                        alignWithLabel: true
                    },
                    gridIndex: 0,
                    data: option.xLabels
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: option.yLabel,
                    position: 'left',
                }
            ],
            series: [
                {
                    name: option.yLabel,
                    type: 'line',
                    data: option.data,
                }
            ]
        };
        this._chart.setOption(charOption);
    }

    setChartOption(chartOption) {
        this._chart.setOption(chartOption);
        return this;
    }

    getChartOption() {
        return this._chart.getOption();
    }

    showLoading() {
        this._chart.showLoading();
    }

    hideLoading() {
        this._chart.hideLoading();
    }

    resize() {
        this._chart.resize();
    }

    dispose() {
        this._chart.dispose();
        this._chartSeries = {};
    }

    setOpenHandler(openHandler) {
        if ($(this._card).find('btn-open').length === 0) {
            const ctrl = $(this._card).find('.tools').append('<button class="btn btn-sm btn-open"><span class="far fa-square" title="open"></span></button>');
            ctrl.find(".btn-open").click(() => {
                if (this._openHandler != null)
                    this._openHandler.apply();
            });
        }

        this._openHandler = openHandler;
        return this;
    }
}