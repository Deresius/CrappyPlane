'''
Created on Apr 17, 2018

@author: Group 4
'''

import os
from clientside import score

class HighScores(object):


    def __init__(self, filename):
        
        self.filename = os.path.join(os.getcwd(), filename)
        try:
            self.myFile = open(self.filename)
        except:
            raise FileNotFoundError("Score board file name is invalid")
        
        self.myScores = []
        for line in self.myFile.readlines():
            splitLine = str(line).split(sep=',')
            self.myScores.append(score.Score(splitLine[0], int(splitLine[1])))
        self.myFile.close()
            
            
    def getScores(self):
        return self.myScores
    
    def sortScores(self):
        self.myScores.sort()
        
    def getFileName(self):
        return self.filename
        
        
    def updateFile(self, newScore):
        self.getScores().append(newScore)
        self.getScores().sort()
        while (len(self.getScores()) > 10):
            self.getScores().pop()
        os.remove(os.path.join(os.getcwd(), self.filename))
        newFile = open(os.path.join(os.getcwd(), self.filename), 'w')
        for item in self.getScores():
            newFile.write(item.getName() + "," + str(item.getScore()) + "\n")
        newFile.close()
        
    def toString(self):
        for item in self.getScores():
            print(item.getName() + ":" + str(item.getScore()))
