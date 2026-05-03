# Video Processing System (CLI)
Build a system that simulates a video platform where users upload videos and the system processes them in the background.

Each video takes time to process (~2 minute simulated).

The system must handle many videos efficiently without freezing the program.

## Video Model
Each video has:

- ID
- name
- status:
    - UPLOADED
    - PROCESSING
    - READY
    - FAILED
## CLI Commands
```
upload  
process  
status  
exit
```
## Requirements
### 1. Upload Videos

- `upload` adds a new video.
- Each video starts with:
    - status = UPLOADED

---

## 2. Show Status

- `status` prints all videos:
    - id
    - name
    - status
## 3. Process Videos (Basic Version)

- `process` starts processing videos.
- Each video must:
    - take ~2 minute (simulated delay)
    - change status:
        - UPLOADED → PROCESSING → READY
## 4. Background Processing

- Processing must NOT block the CLI.
- You must still be able to:
    - upload videos
    - check status
    - start more processing
- More than one video can be processed concurrently.
- Each video must be processed independently.

When many videos are processed:
- system may become slow
- too many tasks may run at once
- output may become chaotic


## 7. Introduce Processing Limit (CORE IDEA)

Now modify the system so:
- only a LIMITED number of videos can be processed at the same time (e.g. 3 or 5)
- You can add an option to set the limit of concurrent videos to be processed

Any extra videos must wait.
## 8. Queue Behavior
When too many videos are processing:
- new videos must wait in line
- they should start automatically when a worker is free

## 9. Failure Simulation

- Some videos randomly fail during processing
- Failed videos must be marked:
    - FAILED
- Failure in one video must NOT stop others
## 10. Final System Requirements

Your system must:
- accept uploads anytime
- process videos in background
- limit number of simultaneous processing videos
- queue extra videos automatically
- show correct statuses
- handle failures safely