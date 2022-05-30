const getDateTime = () => {
	return 'LastSync: ' + new Date().toLocaleString();
};

module.exports = { getDateTime };
