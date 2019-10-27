# Monitor

## Development

To check for dependency updates:

    mvn versions:display-dependency-updates

## Node script

    curl localhost:8081/install > monitor.sh && chmod +x ./monitor.sh && ./monitor.sh main/test
    
## TODO

- Should nodes check ancestors for commands, up to the root? 
- Cache commands, update on node/command list change
