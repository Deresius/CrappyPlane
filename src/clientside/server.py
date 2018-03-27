import zmq
import time


def runServer():
    scores = []
    context = zmq.Context()
    socket = context.socket(zmq.REP)
    socket.bind("tcp://127.0.0.1:5555")
    
    while True:
        #  Wait for next request from client
        print("waiting for message...")
        message = socket.recv()
        if(message != b'exit'):
           print("Received High Score: %s" % message)
           scores.append(message)
        elif(message == b"exit"):
            return
        print(message)
        #  Do some 'work'
        time.sleep(1)
    
        #  Send reply back to client
        socket.send(b"Added High Score")
        
        
if(__name__ == "__main__"): 
    runServer()