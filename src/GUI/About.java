package GUI;

import javax.swing.*;


import javax.swing.border.EmptyBorder;

import java.awt.Font;

public class About extends JFrame implements GlobalVers{

	private static final long serialVersionUID = 1L;
	static DefaultListModel<String> arr = new DefaultListModel<String>();
	private JPanel contentPane;
	private String info = "Lorem ipsum dolor sit amet, consectetur adipiscing elit,sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Penatibus et magnis dis parturient montes. Massa ultricies mi quis hendrerit dolor. Malesuada fames ac turpis egestas maecenas pharetra convallis posuere. Nam aliquam sem et tortor consequat. Sit amet consectetur adipiscing elit ut aliquam. Id venenatis a condimentum vitae sapien pellentesque. Ut tristique et egestas quis ipsum. Feugiat scelerisque varius morbi enim nunc faucibus a pellentesque. Pretium aenean pharetra magna ac placerat vestibulum lectus mauris ultrices. Aliquam sem et tortor consequat id porta nibh venenatis. Tortor at risus viverra adipiscing at in tellus integer feugiat. Non curabitur gravida arcu ac tortor. Eu turpis egestas pretium aenean pharetra magna ac. Velit sed ullamcorper morbi tincidunt ornare massa. Egestas erat imperdiet sed euismod. Turpis cursus in hac habitasse platea dictumst quisque sagittis purus. Sed vulputate mi sit amet. Tortor dignissim convallis aenean et tortor at risus. Scelerisque in dictum non consectetur. felis donec et odio pellentesque diam volutpat. Tellus mauris a diam maecenas sed enim ut sem viverra. Ultrices mi tempus imperdiet nulla malesuada pellentesque elit eget. Curabitur vitae nunc sed velit dignissim sodales ut eu sem. Sed blandit libero volutpat sed cras ornare arcu dui vivamus. Nec feugiat in fermentum posuere. Eget velit aliquet sagittis id consectetur purus ut faucibus. Porttitor massa id neque aliquam. Ultrices eros in cursus turpis. Est ante in nibh mauris cursus mattis molestie a. Commodo viverra maecenas accumsan lacus vel facilisis volutpat. Tempus quam pellentesque nec nam aliquam sem et tortor consequat. Auctor eu augue ut lectus. Elit duis tristique sollicitudin nibh sit amet. Molestie a iaculis at erat. Et netus et malesuada fames ac turpis egestas integer. Porta non pulvinar neque laoreet suspendisse interdum. Lectus mauris ultrices eros in cursus turpis massa. Malesuada fames ac turpis egestas maecenas pharetra convallis. Sed elementum tempus egestas sed sed. Viverra justo nec ultrices dui sapien eget. Enim ut sem viverra aliquet. Interdum varius sit amet mattis vulputate enim nulla. Lectus proin nibh nisl condimentum. Tortor id aliquet lectus proin nibh nisl condimentum id. Id velit ut tortor pretium. Eget duis at tellus at urna condimentum mattis pellentesque id. Sollicitudin ac orci phasellus egestas tellus rutrum. Id diam maecenas ultricies mi eget mauris pharetra et. Vitae semper quis lectus nulla at volutpat diam. Neque laoreet suspendisse interdum consectetur libero id faucibus nisl tincidunt. Nam libero justo laoreet sit amet cursus. Semper eget duis at tellus at urna condimentum mattis pellentesque. Aliquam malesuada bibendum arcu vitae elementum curabitur. Tincidunt nunc pulvinar sapien et. Aliquet nec ullamcorper sit amet risus nullam eget felis. Sapien nec sagittis aliquam malesuada bibendum arcu. Sit amet est placerat in egestas erat. Sed sed risus pretium quam vulputate dignissim suspendisse. Sit amet volutpat consequat mauris. Metus dictum at tempor commodo ullamcorper. Nibh sit amet commodo nulla. Euismod quis viverra nibh cras. Id porta nibh venenatis cras sed felis eget velit. Ullamcorper malesuada proin libero nunc consequat interdum. Vestibulum sed arcu non odio euismod lacinia at quis risus. Nunc mi ipsum faucibus vitae aliquet.";
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ })
	public About() {
		setTitle("About Bank");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 649, 490);
		contentPane = new JPanel();
		contentPane.setBackground(backgroundColor);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAccountList = new JLabel("About Bank");
		lblAccountList.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAccountList.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountList.setBounds(0, 11, 623, 31);
		contentPane.add(lblAccountList);


		JTextArea infoTextarea = new JTextArea(info,6,100);
		infoTextarea.setEditable(false);
		infoTextarea.setWrapStyleWord(true);
		infoTextarea.setLineWrap(true);
		infoTextarea.setFont(new Font("Tahoma", Font.TRUETYPE_FONT, 18));
		JScrollPane scrollPane =new JScrollPane (infoTextarea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
		scrollPane.setBounds(100,100,400,250);
		//getContentPane().add(scrollPane);
		contentPane.add(scrollPane);




	}
}
