'''
Created on Apr 17, 2018

@author: Group 4
'''

import os
from clientside.score import Score

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
            self.myScores.append(Score(splitLine[0], int(splitLine[1])))
        self.myFile.close()
            
            
    def getScores(self):
        return self.myScores
    
    def sortScores(self):
        self.myScores.sort()
        
    def getFileName(self):
        return self.filename
    
    def getLowestScore(self):
        if len(self.getScores()) != 0:
            self.getScores().sort()
            return self.getScores()[len(self.getScores())-1]
        return Score("EmptyScoreboard", 0)
        
        
    
    def updateFile(self, newScore):
        """
        This is called for adding a new score to the scoreboard. It updates the file and maintains the high score
        number of 10 total.
        """
        self.getScores().append(newScore)
        self.getScores().sort()
        while (len(self.getScores()) > 10):
            self.getScores().pop()
        os.remove(os.path.join(os.getcwd(), self.filename))
        newFile = open(os.path.join(os.getcwd(), self.filename), 'w')
        for item in self.getScores():
            newFile.write(item.getName() + "," + str(item.getScore()) + "\n")
        newFile.close()
        
    def getEncodedList(self):
        returnString = ""
        for item in self.getScores():
            returnString += item.getName() + "," + str(item.getScore()) + "\n"
        return returnString.encode(encoding='utf_8', errors='strict')
    
    def toString(self):
        for item in self.getScores():
            print(item.getName() + ":" + str(item.getScore()))




