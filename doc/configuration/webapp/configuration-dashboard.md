# Dashboard Configuration

## Example - Application Overview

```json
{
  "title": "Application Overview",
  "charts": [
    {
      "title": "Instance",
      "width": 4,
      "type": "table",
      "columns": [
        {"name": "instanceName", "title": "instance" },
        "processors",
        {"name": "instanceStartTime", "title": "startTime", "format": "dateTime" },
        {"name": "instanceUpTime", "title": "upTime", "format": "timeDuration" },
        {"name": "heapUsed", "title": "heapUsed(%)" },
        {"name": "heapMax", "format": "binary_byte" },
        {"name" : "processCpuLoad", "title": "processCpuLoad(%)" }
      ],
      "query": {
        "type": "groupBy",
        "fields": [
          "instanceName",
          "processors",
          "instanceStartTime",
          "instanceUpTime",
          {"name": "heapUsed", "expression": "round(heapUsed * 100.0/heapMax, 2)"},
          "heapMax",
          "processCpuLoad"
        ],
        "orderBy": {
          "name": "instanceUpTime",
          "order": "desc"
        }
      }
    }
  ]
}
```

### Column configuration

- title

  The text that will be shown in the dashboard.

- name

  The output name of a metric. Can also be used as title if `title` is not given.
- format

  Supported formats:
    - compact_number
    - binary_byte
    - ...

### Data Configuration

#### Timeseries

#### groupBy

#### SQL-Like

This is the ultimate way.

```json
{
  "sql": "SELECT instanceName, processors, instanceStartTime， instanceUpTime, round(heapUsed * 100.0/heapMax, 2) AS heapUsed, heapMax, processCpuLoad FROM jvm-metrics GROUP BY instanceName ORDER BY instanceUpTime DESC"
}
```

## Example - Get cardinality of application instances

To illustrate cardinality of application instances in chart, add following column to columns of a char description file.

```json
{
  "name": "instanceCount",
  "field": "instanceName",
  "aggregator": "cardinality"
}
```
