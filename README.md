# Monitor

## Development

To check for dependency updates:

    mvn versions:display-dependency-updates

## Node script

    curl localhost:8081/install > monitor.sh && chmod +x ./monitor.sh && ./monitor.sh main/test