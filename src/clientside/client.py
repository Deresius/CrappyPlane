import zmq
from random import randint

def runClient():
    #  Prepare our context and sockets
    context = zmq.Context()
    socket = context.socket(zmq.REQ)
    print("connecting to server...")
    socket.connect("tcp://127.0.0.1:5555")
    
    #  Do 10 requests, waiting each time for a response
    for request in range(1,11):
        print("sending message...")
        score = str(randint(0,100000))
        socket.send(score.encode('ascii'))
        response = socket.recv()
        
        print("Received reply %s [%s]" % (request, response))
    print("sending exit message...")
    socket.send(b"exit")
        
if(__name__ == "__main__"):
    runClient()  
