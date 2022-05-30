const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const captchaImageSchema = new Schema(
	{
		ImageData: { type: String, required: true },
		ImageValue: { type: String, required: true },
		Id: { type: String, required: true },
	},
	{ collection: 'CaptchaImage' }
);

const CaptchaImage = mongoose.model('CaptchaImage', captchaImageSchema);

// export default CaptchaImage;
module.exports = CaptchaImage;
