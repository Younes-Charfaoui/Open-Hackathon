
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

@app.route('/addSaleBlock', methods = ['GET'])
def addSaleBlock():
    file = open('sales.json')
    blockchain = json.load(file)
    blockchain.append(json.loads(request.args.get('block')))
    with open('sales.json','w') as data:    
        json.dump(blockchain,data,indent=4)
    return jsonify(blockchain),200

@app.route('/addMaladyBlock', methods = ['GET'])
def addMaladyBlock():
    file = open('maladies.json')
    blockchain = json.load(file)
    blockchain.append(json.loads(request.args.get('block')))
    with open('maladies.json','w') as data:    
        json.dump(blockchain,data,indent=4)
    return jsonify(blockchain),200
    

app.run(host = '0.0.0.0', port = 5000)
