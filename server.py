
# Importing the libraries
import json
from flask import Flask, jsonify, request


# Creating a Web App
app = Flask(__name__)

@app.route('/getMaladies', methods = ['GET'])
def getMaladiesBlockchain():
    file = open('maladies.json')
    blockchain = json.load(file)
    return jsonify(blockchain), 200

@app.route('/getSales', methods = ['GET'])
def getSalesBlockchain():
    file = open('sales.json')
    blockchain = json.load(file)
    return jsonify(blockchain), 200

@app.route('/display', methods = ['GET'])
def addBlock():
    

app.run(host = '0.0.0.0', port = 5000)
