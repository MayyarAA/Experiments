const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const captchaImageSchema = new Schema(
	{
		data: { type: String, required: true },
		Id: { type: Number, required: true },
	},
	{ collection: 'CaptchaImage' }
);

const CaptchaImage = mongoose.model('CaptchaImage', captchaImageSchema);

// export default CaptchaImage;
module.exports = CaptchaImage;
